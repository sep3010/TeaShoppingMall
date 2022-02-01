package edu.kosmo.pse.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PageVO {
	private int pageNum;
	private int startPage;
	private int endPage;
	private int realEnd;
	
	private boolean pre;
	private boolean next;
	
	private int total;
	private final int AMOUNT = 10;
	
	// private Criteria cri;

	public PageVO(int total, int pageNum) {
		
		this.total = total;
		this.pageNum = pageNum;
		
		this.endPage = (int)(Math.ceil(pageNum / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		this.realEnd = (int)(Math.ceil((total * 1.0) / AMOUNT));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
		this.pre = (this.startPage > 1);
		
		this.next = this.endPage < realEnd;
		
		
	}
	
	
		
}
