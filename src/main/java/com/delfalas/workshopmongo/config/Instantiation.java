package com.delfalas.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.delfalas.workshopmongo.domain.Post;
import com.delfalas.workshopmongo.domain.User;
import com.delfalas.workshopmongo.repository.PostRepository;
import com.delfalas.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
 	private PostRepository postReposiroty;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postReposiroty.deleteAll();
		
		User vini = new User(null, "Vinicius Dantas", "vinidantas@hotmail.com");
		User dani = new User(null, "Danielle Arcanjo", "daniarcanjo@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", vini);
 		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", vini);
		
		userReposiroty.saveAll(Arrays.asList(vini, dani, bob));
		postReposiroty.saveAll(Arrays.asList(post1, post2));
		
	}

}
