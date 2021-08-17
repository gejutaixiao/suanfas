package leetcode.suanfa;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;

public class MongoDBJDBC {

    public static void main( String args[] ){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("获取集合成功");
//
//            Document document = new Document("title", "Mongodb").append("description", "database").append("likes", 100).append("by", "fly");
//
//            ArrayList<Document> documents = new ArrayList<Document>();
//            documents.add(document);
//            collection.insertMany(documents);
//            System.out.println("文档插入成功");

            collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));

            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> iterator = findIterable.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }


        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
