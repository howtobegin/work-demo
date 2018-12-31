package com.example.demo.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
	
	public static void main(String[] args) {
		List<String> urls = new ArrayList<String>();
		urls.add("a");
		urls.add("a1");
		urls.add("a2");
		urls.add("a1");
		urls.add("a3");
		urls.add("a4");
		urls.add("a4");
		urls.add("a3");
		urls.add("a2");
		urls.add("a1");
		urls.add("a1");
		urls.add("a1");
		urls.add("a5");
		urls.add("a3");
		urls.add("a3");
		urls.add("a3");
		urls.add("a4");
		urls.add("a3");

		System.out.println(mostCommon(urls, 5));
		System.out.println(mostCommon2(urls, 5));
		
		System.out.println(1 << 29);
	}
	
	public static List<Map.Entry<String, Long>> mostCommon(List<String> urls, long top) {

		Map<String, Long> counts = urls.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		List<Map.Entry<String, Long>> topN = counts.entrySet().stream()
				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).limit(top).collect(Collectors.toList());

		return topN;
	}

	public static List<Map.Entry<String, Long>> mostCommon2(List<String> urls, long top) {

		final Map<String, Long> counts = new HashMap<>();
		for (String url : urls) {
			counts.merge(url, 1L, Long::sum);
		}

		List<Map.Entry<String, Long>> topN = counts.entrySet().stream()
				.sorted((e1, e2) -> Long.compare(e1.getValue(), e2.getValue())).limit(top).collect(Collectors.toList());

		return topN;
	}

}
