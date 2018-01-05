package com.data.stack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StackTest {

	private Stack<Integer> stack;
	
	public StackTest(Stack<Integer> stack) {
		this.stack = stack;
	}
	
	@Parameters 
	public static List<Object[]> getParameters() {
		List<Object[]> params = new ArrayList<>();
		params.add(new Object[] { new VectorStack<Integer>() });
		
		return params;
	}
	
	@Before
	public void setup() {
		stack = new VectorStack<>();
	}
	
	@Test
	public void givenStack_whenAddInteger_integerShouldBeInStack() {
		stack.push(1);

		assertThat(stack.peek()).isEqualTo(1);
		assertThat(stack.empty()).isFalse();
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void givenEmptyStack_whenPop_shouldReturnArrayOutOfBounds() {
		stack.pop();
	}
	
	@Test
	public void givenStack_whenAddInteger_stackShouldReturnNotEmpty() {
		stack.push(1);

		assertThat(stack.empty()).isFalse();
	}
	
	@Test
	public void givenEmptyStack_whenCallEmptyMethod_stackShouldReturnTrue() {

		assertThat(stack.empty()).isTrue();
	}
	
	@Test
	public void givenStack_whenRemoveInteger_stackShouldPeekNextInt() {
		stack.push(1);
		stack.push(2);
		
		stack.pop();

		assertThat(stack.peek()).isEqualTo(1);
	}
	
	@Test
	public void givenStack_whenSearchInteger_stackShouldReturnCorrectIndex() {
		stack.push(100);
		stack.push(101);
		stack.push(102);
		
		assertThat(stack.search(101)).isEqualTo(1);
	}
	
	@Test
	public void givenStack_whenSearchIntegerThatDoesNotExist_stackShouldReturnNegativeOne() {
		stack.push(100);
		stack.push(101);
		stack.push(102);
		
		assertThat(stack.search(103)).isEqualTo(-1);
	}
	
	@Test
	public void givenStack_whenCallingToString_stackShouldReturnCorrectString() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		assertThat(stack.toString()).contains(STACK_TOSTRING);
	}

	private static final String STACK_TOSTRING = "toString()=[1, 2, 3]]";
}
