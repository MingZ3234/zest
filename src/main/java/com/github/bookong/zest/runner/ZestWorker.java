package com.github.bookong.zest.runner;

import com.github.bookong.zest.annotation.ZestSource;
import com.github.bookong.zest.exception.ZestException;
import com.github.bookong.zest.executor.AbstractExecutor;
import com.github.bookong.zest.testcase.Source;
import com.github.bookong.zest.testcase.ZestData;
import com.github.bookong.zest.util.Messages;
import com.github.bookong.zest.util.ZestReflectHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiang Xu
 */
public abstract class ZestWorker {

    protected static Logger               logger      = LoggerFactory.getLogger(ZestWorker.class);

    private Map<String, AbstractExecutor> executorMap = new HashMap<>();

    private Map<String, Object>           operatorMap = new HashMap<>();

    protected void loadAnnotation(Object test) {
        Class<?> clazz = test.getClass();
        while (!Object.class.getName().equals(clazz.getName())) {
            for (Field f : clazz.getDeclaredFields()) {
                ZestSource zestSource = f.getAnnotation(ZestSource.class);
                if (zestSource == null) {
                    continue;
                }

                AbstractExecutor executor;
                try {
                    executor = zestSource.executorClass().newInstance();
                    executorMap.put(zestSource.value(), executor);
                } catch (Exception e) {
                    throw new ZestException(Messages.parseExecutor(zestSource.value(),
                                                                   zestSource.executorClass().getName()),
                                            e);
                }

                Object obj = ZestReflectHelper.getValue(test, f.getName());
                if (!executor.supportedOperatorClass().isAssignableFrom(obj.getClass())) {
                    throw new ZestException(Messages.parseOperator(zestSource.value(),
                                                                   executor.supportedOperatorClass().getName()));
                }

                if (!operatorMap.containsKey(zestSource.value())) {
                    operatorMap.put(zestSource.value(), obj);
                }
            }

            clazz = clazz.getSuperclass();
        }
    }

    public void initDataSource(ZestData zestData) {
        for (Source source : zestData.getSourceList()) {
            AbstractExecutor executor = executorMap.get(source.getId());

            executor.clear(this, zestData, source);
            executor.init(this, zestData, source);
        }
    }

    public void verifyDataSource(ZestData zestData) {
        for (Source source : zestData.getSourceList()) {
            executorMap.get(source.getId()).verify(this, zestData, source);
        }
    }

    public Object getOperator(String sourceId) {
        Object operation = operatorMap.get(sourceId);
        if (operation == null) {
            throw new ZestException(Messages.operatorUnbound(sourceId));
        }
        return operation;
    }

    public <T> T getOperator(String sourceId, Class<T> operatorClass) {
        Object operation = getOperator(sourceId);

        if (operatorClass.isAssignableFrom(operation.getClass())) {
            return operatorClass.cast(operation);
        } else {
            throw new ZestException(Messages.operatorCast(sourceId, operation.getClass().getName(),
                                                          operatorClass.getName()));
        }
    }

    public AbstractExecutor getExecutor(String sourceId) {
        AbstractExecutor executor = executorMap.get(sourceId);
        if (executor == null) {
            throw new ZestException(Messages.operatorUnbound(sourceId));
        }
        return executor;
    }

    public <E extends AbstractExecutor> E getExecutor(String sourceId, Class<E> executorClass) {
        return executorClass.cast(executorMap.get(sourceId));
    }
}
