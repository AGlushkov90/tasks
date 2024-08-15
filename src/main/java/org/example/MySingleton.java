package org.example;
// реализовать потокобезопасный Singleton (сначало ленивый, потом нет)
public class MySingleton {
    private static volatile MySingleton instance;

    public static MySingleton getInstance() {
        MySingleton result = instance;
        if (result == null) {
            synchronized (MySingleton.class) {
                result = instance;
                if(result == null) {
                    instance = new MySingleton();
                    result = instance;
                }
            }
        }
        return result;
    }
}
