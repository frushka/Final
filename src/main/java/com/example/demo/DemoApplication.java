package com.example.demo;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/ok")
	public String ok() throws JSONException {
		// Задаю рандомные значения, с которыми далее буду работать.
		// Параметры задаю через числа, подразумевая, что это ID компаний в
		// некоторой базе данных, аналогично с профессией (условно, сортировка по тяжести работы)
		Integer jsonChange = new SecureRandom().nextInt( 100 - 1) + 1;
		Integer jsonAge = new SecureRandom().nextInt( 130 - 1) + 1;
		Integer jsonProfession = new SecureRandom().nextInt( 150 - 1) + 1;
		Integer jsonCompany = new SecureRandom().nextInt( 150 - 1) + 1;
		Integer jsonId = new SecureRandom().nextInt( 100 - 1) + 1;


		//Создаю объекты json
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Nikolai");
		jsonObject.put("surname", "Ovechkin");
		jsonObject.put("changeForCredit", jsonChange);
		jsonObject.put("agePeople", jsonAge);
		jsonObject.put("professionPeople", jsonProfession);
		jsonObject.put("company", jsonCompany);
		jsonObject.put("userId", jsonId);

		// Вытаскиваю объекты из json в Java-объект
		People debtor = new People((String)jsonObject.get("name"), (String)jsonObject.get("surname"),
				(Integer)jsonObject.get("changeForCredit"), (Integer)jsonObject.get("agePeople"),
				(Integer)jsonObject.get("professionPeople"), (Integer)jsonObject.get("company"), (Integer)jsonObject.get("userId"));

		JSONObject Answer = new JSONObject();
		Answer.put("userId:", debtor.getUserId());
		Answer.put("name:", debtor.getName());
		Answer.put("surname", debtor.getSurname());

		if (debtor.getAgePeople()<50 && debtor.getCompany()<10 && debtor.getProfessionPeople()>10){
			if (debtor.getChangeForCredit()>50) {
				Answer.put("Loan response", "Loan approved");
			}
			else {
				Answer.put("Loan response", "Not enough information. Need salary information");
			}
		}
		else{
			if (debtor.getProfessionPeople()>100 && debtor.getCompany()<3){
				if (debtor.getChangeForCredit()>80) {
					Answer.put("Loan response", "Approved");
				}
				else {
					Answer.put("Loan response", "More information is needed. Savings section");
				}
			}
			else{
				Answer.put("Loan response", "Rejection");
			}
		}

		return String.valueOf(Answer);
	}
}
