package files.bean;

public class FilesDTO {
	private int seq;         	// 일렬번호
  	private int community_seq;  // 커뮤니티 글 번호
  	private String dir;         // 폴더 이름
  	private String filename;   	// 파일 이름
  	private String originname;   // 원본 파일 이름
    private int filesize;     	// 파일 크기
    private String filetype;   	// 파일 형식
    private String reg_date;   	// 등록일
   
    public int getSeq() {
      return seq;
   }
   public void setSeq(int seq) {
      this.seq = seq;
   }
   public int getCommunity_seq() {
      return community_seq;
   }
   public void setCommunity_seq(int community_seq) {
      this.community_seq = community_seq;
   }
   public String getDir() {
      return dir;
   }
   public void setDir(String dir) {
      this.dir = dir;
   }
   public String getFilename() {
      return filename;
   }
   public void setFilename(String filename) {
      this.filename = filename;
   }
   public String getOriginname() {
	return originname;
	}
	public void setOriginname(String originname) {
		this.originname = originname;
	}
	public int getFilesize() {
      return filesize;
   }
   public void setFilesize(int filesize) {
      this.filesize = filesize;
   }
   public String getFiletype() {
      return filetype;
   }
   public void setFiletype(String filetype) {
      this.filetype = filetype;
   }
   public String getReg_date() {
      return reg_date;
   }
   public void setReg_date(String reg_date) {
      this.reg_date = reg_date;
   }
    
    
}