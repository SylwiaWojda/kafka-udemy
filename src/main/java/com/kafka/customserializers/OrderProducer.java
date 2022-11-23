package com.kafka.customserializers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


public class OrderProducer {

    public static void main(String[] args) {
        MessageDto msgProd = MessageDto.builder().message("test").version("1.0").build();

        KafkaProducer<String, MessageDto> producer = createKafkaProducer();
        producer.send(new ProducerRecord<String, MessageDto>("TOPIC", "1", msgProd));
        System.out.println("Message sent " + msgProd);
        producer.close();

//        Properties props = new Properties();
//        props.setProperty("bootstrap.servers", "localhost:9092");
//        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        //props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
//        props.setProperty("value.serializer", "com.kafka.customserializers.OrderSerializer");
//
//
//        KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(props);
//        Order order = new Order();
//        order.setCustomerName("Sylwia");
//        order.setProduct("Iphone");
//        order.setQuantity(1);
//        ProducerRecord<String,Order> record = new ProducerRecord<>("OrderCSTopic", order.getCustomerName(), order);
//
//        try {
//            producer.send(record);
////            System.out.println(recordMetadata.partition());
////            System.out.println(recordMetadata.offset());
////            System.out.println("Message send suc.");
//        } catch(Exception e) {
//            e.printStackTrace();
//        } finally {
//            producer.close();
//        }




    }


    private static KafkaProducer<String, MessageDto> createKafkaProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "123"); //todo
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.kafka.customserializers.CustomSerializer");

        return new KafkaProducer(props);
    }


}
