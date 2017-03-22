package com.ust.clones.fullfilment.mock;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fullfilment")
@EnableAutoConfiguration
@ComponentScan("com.ust.clones")
@SpringBootApplication
public class RequestController {

	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public Response execute(HttpSession session, 
			@RequestParam(required = true, value = "userId") String userId,
			@RequestParam(required = true, value = "pin") String pin,
			@RequestParam(required = false, value = "lastName") String lastName) {
		
		System.out.println("In Service /fullfilment/resetPassword. User = " + userId + ", Pin = " + pin + ", Last Name = " + lastName);
		
		Response response = new Response();
		String newPassword = "xy$123#11" + (int) (Math.random()*10);
		response.setStatus("200");
		response.setMessage("You gave me userId = '" + userId + "', Pin = '" + pin + "'. New Password is = \"" + newPassword + "\"");
		response.setPassword(newPassword);
		
		System.out.println("Request Complete");
		
		return response;
	}
	
	static class Response {
		private String status;
		private String message;
		private String password;
		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}
		/**
		 * @return the message
		 */
		public String getMessage() {
			return message;
		}
		/**
		 * @param message the message to set
		 */
		public void setMessage(String message) {
			this.message = message;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RequestController.class, args);  
	}
}
 