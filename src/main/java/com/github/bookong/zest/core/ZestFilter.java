package com.github.bookong.zest.core;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

public class ZestFilter extends Filter {

    private Filter filter;

    public ZestFilter(Filter filter){
        this.filter = filter;
    }

    @Override
    public boolean shouldRun(Description description) {
        String desiredDescription = filter.describe();
        if (description.isTest()) {
            String className = description.getClassName();
            String methodName = description.getMethodName();
            int pos = methodName.indexOf("[");
            if (pos > 0) {
                methodName = methodName.substring(0, pos).trim();
            }

            return desiredDescription.indexOf(className) > 0 && desiredDescription.indexOf(methodName) > 0;
        }

        // explicitly check if any children want to run
        for (Description each : description.getChildren()) {
            if (shouldRun(each)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String describe() {
        return filter.describe();
    }
}
