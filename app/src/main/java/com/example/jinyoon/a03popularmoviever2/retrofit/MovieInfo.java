package com.example.jinyoon.a03popularmoviever2.retrofit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jin Yoon on 4/25/2016.
 */
public class MovieInfo {

    private List<Results> results = new ArrayList<Results>();


    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

}






























//public class MovieInfo {
//
//    private List<Result> results;
//    public List<Result> getResults() {
//        return results;
//    }
//
//    public void setResults(List<Result> results) {
//        this.results = results;
//    }
//
//    public class Result {
//
//        private String posterPath;
//        private String overview;
//        private String releaseDate;
//        private Integer id;
//        private String originalTitle;
//        private Double voteAverage;
//
//        public String getPosterPath() {
//            return posterPath;
//        }
//
//        public void setPosterPath(String posterPath) {
//            this.posterPath = posterPath;
//        }
//
//        public String getOverview() {
//            return overview;
//        }
//
//        public void setOverview(String overview) {
//            this.overview = overview;
//        }
//
//        public String getReleaseDate() {
//            return releaseDate;
//        }
//
//        public void setReleaseDate(String releaseDate) {
//            this.releaseDate = releaseDate;
//        }
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getOriginalTitle() {
//            return originalTitle;
//        }
//
//        public void setOriginalTitle(String originalTitle) {
//            this.originalTitle = originalTitle;
//        }
//
//        public Double getVoteAverage() {
//            return voteAverage;
//        }
//
//        public void setVoteAverage(Double voteAverage) {
//            this.voteAverage = voteAverage;
//        }
//    }
//}





//    private String id;
//    private String posterPath;
//    private String title;
//    private String synopsis;
//    private String rating;
//    private String releaseDate;
//
//    public MovieInfo() {
//
//    }
//
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getPosterPath() {
//        return posterPath;
//    }
//
//    public void setPosterPath(String posterPath) {
//        this.posterPath = posterPath;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getSynopsis() {
//        return synopsis;
//    }
//
//    public void setSynopsis(String synopsis) {
//        this.synopsis = synopsis;
//    }
//
//    public String getRating() {
//        return rating;
//    }
//
//    public void setRating(String rating) {
//        this.rating = rating;
//    }
//
//    public String getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    public MovieInfo(Parcel source) {
//        id=source.readString();
//        posterPath=source.readString();
//        title=source.readString();
//        synopsis=source.readString();
//        rating=source.readString();
//        releaseDate=source.readString();
//
//    }
//
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(id);
//        dest.writeString(posterPath);
//        dest.writeString(title);
//        dest.writeString(synopsis);
//        dest.writeString(rating);
//        dest.writeString(releaseDate);
//    }
//
//    public static final Parcelable.Creator<MovieInfo> CREATOR
//            = new Parcelable.Creator<MovieInfo>(){
//
//        @Override
//        public MovieInfo createFromParcel(Parcel source) {
//            return new MovieInfo(source);
//        }
//
//        @Override
//        public MovieInfo[] newArray(int size) {
//            return new MovieInfo[size];
//        }
//    };

