package com.data.list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList<String> list;
	
	@Before
	public void setup() {
		list = new LinkedList<>();
	}
	
	/* LIST ADD */
	@Test
	public void givenList_whenAddItem_shouldBeInList() {
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");

		assertThat(list).containsSequence(
				"Item 1"
				, "Item 2"
				, "Item 3");
	}
	
	@Test
	public void givenList_whenAddNullItem_shouldThrowException() {		
		Throwable thown = catchThrowable(() -> {list.add(null); });

		assertThat(thown).isInstanceOf(NullPointerException.class);
	}

	/* LIST REMOVE */
	@Test
	public void givenList_whenRemoveItem_itemShouldNotBeInList() {
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");

		list.remove("Item 2");
		
		assertThat(list).containsSequence(
				"Item 1"
				, "Item 3");
	}
	
	@Test
	public void givenList_whenRemoveHeadItem_itemShouldNotBeInList() {
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");

		list.remove("Item 1");
		
		assertThat(list).containsSequence(
				"Item 2"
				, "Item 3");
	}
	
	@Test
	public void givenList_whenRemoveLastItem_itemShouldNotBeInList() {
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");

		list.remove("Item 3");
		
		assertThat(list).containsSequence(
				"Item 1"
				, "Item 2");
	}
	
	@Test
	public void givenListOfOne_whenRemoveItem_itemShouldNotBeInList() {
		list.add("Item 1");

		list.remove("Item 1");
		
		assertThat(list).isEmpty();
	}
	
	@Test
	public void givenList_whenRemoveItemNotExist_shouldReturnFalse() {
		list.add("Item 1");
		list.add("Item 2");

		boolean returnResult = list.remove("Item 3");
		
		assertThat(returnResult).isFalse();
	}
	
	@Test
	public void givenList_whenRemoveEmptyItem_shouldThrowException() {
		Throwable thown = catchThrowable(() -> {list.remove(null); });
		
		assertThat(thown).isInstanceOf(NullPointerException.class);
	}
	
	@Test
	public void givenEmptyList_whenRemoveItem_shouldThrowException() {
		Throwable thown = catchThrowable(() -> {list.remove("Item 1"); });

		assertThat(thown).isInstanceOf(NullPointerException.class);
	}
	
	/* TOSTRING */
	@Test
	public void givenList_callToString_shouldListAllValues() {
		list.add("Item 1");
		list.add("Item 2");

		assertThat(list.toString()).hasToString("[Item 1 Item 2 ]");
	}
}
