package com.daniel.math.services;

import org.springframework.stereotype.Component;

@Component
public class MathProcessorImpl implements MathProcessor {

	private void delay() {
		/*try {
			Thread.sleep(2048);
		}
		catch (InterruptedException e) {
		}*/
	}
 
	@Override
	public int add(int x, int y) {
		delay();
		return x + y;
	}

	// subtract method
	@Override
	public int subtract(int x, int y) {
		delay();
		return x - y;
	}

	@Override
	public double divide(int x, int y) {
		delay();
		return 01.0 * x / y;
	}

	@Override
	public int multiply(int x, int y) {
		delay();
		return x * y;
	}
	
	@Override
	public Integer Add(Integer x, Integer y) {
		return x + y;
	}
}
