package com.china.test.sample.tsmain.mongodb;

import com.alibaba.fastjson.JSON;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 * mongodb连接示例
 * <p>
 * https://cloud.mongodb.com/
 * account:godaipl
 * pass:yandongjun
 */
public class TestMongoDb {

    public static void main(String[] args) {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://root:Mongodb1225@cluster0-jopmn.mongodb.net/test?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        System.out.println(database.getName());
//        #以下代码生成的较慢，所以要等一会儿再看有没有创建好collection
//        database.createCollection("bobo_test");
//        System.out.println(JSON.toJSONString(database.listCollections()));

        System.out.println(JSON.toJSONString(database.listCollections()));

        mongoClient.close();
    }
}
