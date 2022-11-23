//package com.kafka;
//
//import org.apache.kafka.clients.producer.RecordMetadata;
//
//public class OrderCallback implements org.apache.kafka.clients.producer.Callback {
//    @Override
//    public void onCompletion(RecordMetadata metadata, Exception exception) {
//            System.out.println(metadata.partition());
//            System.out.println(metadata.offset());
//            System.out.println("Message send suc.");
//            if(exception!=null) {
//                exception.printStackTrace();
//            }
//
//    }
//}
