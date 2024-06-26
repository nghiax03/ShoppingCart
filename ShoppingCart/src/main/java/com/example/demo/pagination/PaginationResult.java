package com.example.demo.pagination;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;

import lombok.Getter;
@Getter
public class PaginationResult<E> {
	private int totalRecords;
	private int currentPage;
	private List<E> list;
	private int maxResult;
	private int totalPages;
	
	private int maxNavigationPage;
	
	private List<Integer> navigationPages;
	
	public PaginationResult(Query<E> query, int page, int maxResult, int maxNavigationPage) {
		final int pageIndex = page - 1 < 0 ? 0 : page - 1;
		int fromRecordIndex = pageIndex * maxResult;
		int maxRecordIndex = fromRecordIndex + maxResult;
		
		ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
		
		List<E> results = new ArrayList<>();
		
		boolean hasResult = resultScroll.first();
		if(hasResult) {
			hasResult = resultScroll.scroll(fromRecordIndex);
			if(hasResult) {
				do {
					E record = (E)resultScroll.get(0);
				} while (resultScroll.next()//
						&& resultScroll.getRowNumber() >= fromRecordIndex
						&& resultScroll.getRowNumber() < maxRecordIndex);
			}
			resultScroll.last();
		}
		this.totalPages = resultScroll.getRowNumber() + 1;
		this.currentPage = pageIndex + 1;
		this.list = results;
		this.maxResult = maxResult;
		
		if(this.totalRecords % this.maxResult == 0) {
			this.totalPages = this.totalRecords / this.maxResult;
		}else {
			this.totalPages = (this.totalPages / this.maxResult) + 1;
		}
		this.maxNavigationPage = maxNavigationPage;
		if(maxNavigationPage < totalPages) {
			this.maxNavigationPage = maxNavigationPage;
		}
		this.calcNavigationPages();
	}
	
	private void calcNavigationPages() {
		this.navigationPages = new ArrayList<Integer>();
		
		int current = this.currentPage > this.totalPages ? this.totalPages : this.currentPage;
		int begin = current - this.maxNavigationPage / 2;
		int end = current + this.maxNavigationPage / 2;
		navigationPages.add(1);
		if(begin > 2) {
			navigationPages.add(-1);
		}
		for(int i=begin; i<end; i++) {
			if(i>1 && i < this.totalPages) {
				navigationPages.add(i);
			}
		}
		
		if(end < this.totalPages - 2) {
			navigationPages.add(-1);
		}
		navigationPages.add(this.totalPages);
	}
}
