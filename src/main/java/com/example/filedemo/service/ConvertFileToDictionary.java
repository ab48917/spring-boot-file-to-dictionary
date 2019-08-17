package com.example.filedemo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ConvertFileToDictionary {

	/*
	 * This class will be used to retrieve the words from file and store into list
	 * For sake of large dataset, will create a list specific to each alphabet. If
	 * user would like to search a word than based on it's first alphabet specifc
	 * list will be called and used will be notified if word exists or not
	 */

	public void storeFileToDictionary(MultipartFile file) {
		BufferedReader br;
		List<String> result = new ArrayList<>();
		try {

			String line;
			InputStream is = file.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				storeWordsToList(line);
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private void storeWordsToList(String line) {
		String[] words = line.split(" ");
		Arrays.asList(words).stream().forEach(word -> associateWordToLis(word));
	}

	private void associateWordToLis(Object word) {

		String charac = word.toString().substring(0, 1).toLowerCase();
		List<String> discList = DictionaryListFactory.getDictionaryList(charac);
		discList.add(word.toString());

	}

	public Boolean checkIfWordExists(String word) {

		String charac = word.toString().substring(0, 1).toLowerCase();
		List<String> discList = DictionaryListFactory.getDictionaryList(charac);
		if (discList.contains(word))
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}
}
