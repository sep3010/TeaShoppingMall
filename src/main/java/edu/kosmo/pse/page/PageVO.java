package edu.kosmo.pse.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PageVO {
	private int startPage;
	private int endPage;
	
	private boolean pre;
	private boolean next;
	
	private int total;
	
	private Criteria cri;

	public PageVO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
		this.pre = (this.startPage > 1);
		
		this.next = this.endPage < realEnd;
		
		
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page).queryParam("amount", cri.getAmount()).build();
		
		return uriComponentsBuilder.toUriString();
		
		
	}
	
		
}
