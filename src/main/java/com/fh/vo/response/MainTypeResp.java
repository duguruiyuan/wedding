package com.fh.vo.response;

import java.util.List;

import com.fh.vo.ResponseBody;

public class MainTypeResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<MainTypeInfo> mainTypeInfos;

	public static class MainTypeInfo {
		private Long id;

		private String name;

		private String level;

		private String imageUrl;

		private Long parentId;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public Long getParentId() {
			return parentId;
		}

		public void setParentId(Long parentId) {
			this.parentId = parentId;
		}

	}

	public List<MainTypeInfo> getMainTypeInfos() {
		return mainTypeInfos;
	}

	public void setMainTypeInfos(List<MainTypeInfo> mainTypeInfos) {
		this.mainTypeInfos = mainTypeInfos;
	}
}
