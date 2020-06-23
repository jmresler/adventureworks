package org.jmresler.aw.patterns;


/**
 *
 * @author johnm
 */
public class SingletonTemplate {
    
    private SingletonTemplate() {
    }
    
    public static SingletonTemplate getInstance() {
        return SingletonTemplateHolder.INSTANCE;
    }
    
    private static class SingletonTemplateHolder {

        private static final SingletonTemplate INSTANCE = new SingletonTemplate();
    }
}
