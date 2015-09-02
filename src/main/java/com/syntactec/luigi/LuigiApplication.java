package com.syntactec.luigi;

import com.syntactec.luigi.domain.Message;
import com.syntactec.luigi.domain.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.geo.Point;

@SpringBootApplication
public class LuigiApplication implements CommandLineRunner {

    @Autowired
    MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(LuigiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        messageRepository.deleteAll();

        Message message = new Message();
        message.setContent("Test 1 Content");
        message.setLocation(new Point(-70.285227, 43.674389));

        messageRepository.save(message);
    }
}
