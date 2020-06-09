package com.guier.util;

import java.util.concurrent.atomic.AtomicInteger;

public class CountUtil {
	private static final AtomicInteger num = new AtomicInteger(0);

	public static int get() {
		return num.incrementAndGet();
	}
}
