package com.example.mvpdemo.mvedemo;

import java.util.List;

public class NetResponse {


    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {

        private String pic_s210;
        private String web_url;
        private String pic_s444;
        private String name;
        private int count;
        private String comment;
        private int type;
        private String pic_s192;
        private String pic_s260;
        private List<ContentBean> content;

        public String getPic_s210() {
            return pic_s210;
        }

        public void setPic_s210(String pic_s210) {
            this.pic_s210 = pic_s210;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getPic_s444() {
            return pic_s444;
        }

        public void setPic_s444(String pic_s444) {
            this.pic_s444 = pic_s444;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getPic_s192() {
            return pic_s192;
        }

        public void setPic_s192(String pic_s192) {
            this.pic_s192 = pic_s192;
        }

        public String getPic_s260() {
            return pic_s260;
        }

        public void setPic_s260(String pic_s260) {
            this.pic_s260 = pic_s260;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class ContentBean {
            /**
             * all_rate : 96,128,224,320,flac
             * song_id : 605610682
             * rank_change : 0
             * biaoshi : first,lossless,perm-1
             * author : 龙梅子
             * album_id : 605610677
             * title : 过
             * album_title : 过
             */

            private String all_rate;
            private String song_id;
            private String rank_change;
            private String biaoshi;
            private String author;
            private String album_id;
            private String title;
            private String album_title;

            public String getAll_rate() {
                return all_rate;
            }

            public void setAll_rate(String all_rate) {
                this.all_rate = all_rate;
            }

            public String getSong_id() {
                return song_id;
            }

            public void setSong_id(String song_id) {
                this.song_id = song_id;
            }

            public String getRank_change() {
                return rank_change;
            }

            public void setRank_change(String rank_change) {
                this.rank_change = rank_change;
            }

            public String getBiaoshi() {
                return biaoshi;
            }

            public void setBiaoshi(String biaoshi) {
                this.biaoshi = biaoshi;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(String album_id) {
                this.album_id = album_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAlbum_title() {
                return album_title;
            }

            public void setAlbum_title(String album_title) {
                this.album_title = album_title;
            }
        }
    }
}
