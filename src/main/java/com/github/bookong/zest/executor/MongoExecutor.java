package com.github.bookong.zest.executor;

import com.github.bookong.zest.exception.ZestException;
import com.github.bookong.zest.runner.ZestWorker;
import com.github.bookong.zest.testcase.AbstractTable;
import com.github.bookong.zest.testcase.Source;
import com.github.bookong.zest.testcase.ZestData;
import com.github.bookong.zest.testcase.mongo.Collection;
import com.github.bookong.zest.util.Messages;
import com.github.bookong.zest.util.ZestReflectHelper;
import org.junit.Assert;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Set;

/**
 * @author Jiang Xu
 */
public class MongoExecutor extends AbstractExecutor {

    @Override
    protected void init(ZestWorker worker, ZestData zestData, Source source, AbstractTable data) {
        if (!(data instanceof Collection)) {
            throw new ZestException(Messages.executorMatch());
        }

        Collection collection = (Collection) data;
        List<Object> dataList = collection.getDocuments();
        if (dataList.isEmpty()) {
            return;
        }

        MongoOperations operation = worker.getSourceOperation(source.getId(), MongoOperations.class);
        operation.insert(dataList, collection.getEntityClass());
    }

    @Override
    protected void verify(ZestWorker worker, ZestData zestData, Source source, AbstractTable data) {
        if (!(data instanceof Collection)) {
            throw new ZestException(Messages.executorMatch());
        }

        Collection collection = (Collection) data;
        MongoOperations operation = worker.getSourceOperation(source.getId(), MongoOperations.class);

        Query query = new Query();
        if (collection.getMongoSort() != null) {
            query.with(collection.getMongoSort());
        }

        List<?> actualList = operation.find(query, collection.getEntityClass());
        Assert.assertEquals(Messages.checkDocSize(source.getId(), collection.getName()),
                            collection.getDocuments().size(), actualList.size());

        for (int i = 0; i < collection.getDocuments().size(); i++) {
            Object expected = collection.getDocuments().get(i);
            Object actual = actualList.get(i);
            verify(worker, zestData, source, operation, collection, i + 1, expected, actual);
        }
    }

    /**
     * 简单验证数据，如果对验证有特殊需求，需要在子类里覆盖这个方法
     */
    public void verify(ZestWorker worker, ZestData zestData, Source source, MongoOperations operation,
                       Collection collection, int rowIdx, Object expected, Object actual) {
        System.out.println("TODO");
    }

    @Override
    public void clear(ZestWorker worker, ZestData zestData, Source source) {
        Set<String> tableNames = findAllTableNames(source);
        MongoOperations operation = worker.getSourceOperation(source.getId(), MongoOperations.class);

        for (String tableName : tableNames) {
            operation.dropCollection(tableName);
        }
    }

}