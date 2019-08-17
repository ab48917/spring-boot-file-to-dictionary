package com.example.filedemo.service;

import java.util.LinkedList;
import java.util.List;

import com.example.filedemo.constants.ApplicationConstants;

public class DictionaryListFactory {
	
	public static List<String> getDictionaryList(String charac) {
		List <String> list;
		
		switch(charac) {
		case "a" :
			list = ApplicationConstants.a;
			break;
		case "b" :
			list = ApplicationConstants.b;
			break;
		case "c" :
			list = ApplicationConstants.c;
			break;
		case "d" :
			list = ApplicationConstants.d;
			break;
		case "e" :
			list = ApplicationConstants.e;
			break;
		case "f" :
			list = ApplicationConstants.f;
			break;
		case "g" :
			list = ApplicationConstants.g;
			break;
		case "h" :
			list = ApplicationConstants.h;
			break;
		case "i" :
			list = ApplicationConstants.i;
			break;
		case "j" :
			list = ApplicationConstants.j;
			break;
		case "k" :
			list = ApplicationConstants.k;
			break;
		case "l" :
			list = ApplicationConstants.l;
			break;
		case "m" :
			list = ApplicationConstants.m;
			break;
		case "n" :
			list = ApplicationConstants.n;
			break;
		case "o" :
			list = ApplicationConstants.o;
			break;
		case "p" :
			list = ApplicationConstants.p;
			break;
		case "q" :
			list = ApplicationConstants.q;
			break;
		case "r" :
			list = ApplicationConstants.r;
			break;
		case "s" :
			list = ApplicationConstants.s;
			break;
		case "t" :
			list = ApplicationConstants.t;
			break;
		case "u" :
			list = ApplicationConstants.u;
			break;
		case "v" :
			list = ApplicationConstants.v;
			break;
		case "w" :
			list = ApplicationConstants.w;
			break;
		case "x" :
			list = ApplicationConstants.x;
			break;
		case "y" :
			list = ApplicationConstants.y;
			break;
		case "z" :
			list = ApplicationConstants.z;
			break;
		default :
			list =new LinkedList<>();
		}
		
		return list;
	}

}
