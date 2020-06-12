package com.jbnu.comall.util;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jbnu.comall.model.Product;
import com.jbnu.comall.model.Rating;
import com.jbnu.comall.model.Review;
import com.jbnu.comall.model.Examine;
import com.jbnu.comall.model.TrendList;
import com.jbnu.comall.model.TrendView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;


public class DBHelper {
    private static final DBHelper ourInstance = new DBHelper();

    public static DBHelper getInstance() {
        return ourInstance;
    }

    private DBHelper() {
    }

    public void getProduct(String category, Consumer<List<Product>> consumer) {
        FirebaseDatabase.getInstance()
                .getReference("product")
                .child(category)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List<HashMap<String, Object>> maptList = (List<HashMap<String, Object>>) dataSnapshot.getValue();
                        List<Product> productList = new ArrayList<>();

                        for (HashMap<String, Object> map : maptList) {
                            Product product = new Product();
                            product.setName((String) map.get("name"));
                            product.setPrice(Math.toIntExact((Long) map.get("price")));
                            product.setProperties((List<String>) map.get("properties"));
                            product.setThumbnail((String) map.get("thumbnail"));
                            List<Review> reviewList = new ArrayList<>();


                            for (HashMap<String, Object> review : (List<HashMap<String, Object>>) map.get("reviews")) {
                                Review reviewObject = new Review();
                                reviewObject.setDate(Math.toIntExact((Long) review.get("date")));
                                reviewObject.setFrom((String) review.get("from"));
                                reviewObject.setName((String) review.get("name"));
                                reviewObject.setRating(Float.valueOf(String.valueOf(review.get("rating"))));
                                reviewObject.setReview((String) review.get("review"));
                                reviewList.add(reviewObject);

                            }

                            product.setReviews(reviewList);
                            productList.add(product);

                        }


                        consumer.accept(productList);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }

                });
    }

    public void getExamine(String category, Consumer<List<Examine>> consumer) {
        FirebaseDatabase.getInstance()
                .getReference("examine")
                .child(category)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List<HashMap<String, Object>> maptList = (List<HashMap<String, Object>>) dataSnapshot.getValue();
                        List<Examine> examineList = new ArrayList<>();

                        for (HashMap<String, Object> map : maptList) {
                            Examine examine = new Examine();
                            examine.setExamine_info((String) map.get("info"));
                            examine.setExamine_text((String) map.get("read"));

                            examineList.add(examine);

                        }
                        consumer.accept(examineList);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });
    }

    public void getTrend(String category, Consumer<List<TrendList>> consumer) {
        FirebaseDatabase.getInstance()
                .getReference("trend")
                .child(category)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List<HashMap<String, Object>> maptList = (List<HashMap<String, Object>>) dataSnapshot.getValue();
                        List<TrendList> trendList = new ArrayList<>();

                        for (HashMap<String, Object> map : maptList) {
                            TrendList trend = new TrendList();
                            trend.setTrendtext((String) map.get("trendname"));
                            List<TrendView> trendViewList = new ArrayList<>();


                            for (HashMap<String, Object> trend_views : (List<HashMap<String, Object>>) map.get("trendview")) {
                                TrendView trendObject = new TrendView();
                                trendObject.setTrend_image((String) trend_views.get("image"));
                                trendObject.setTrend_photo((String) trend_views.get("photo"));
                                trendViewList.add(trendObject);
                            }

                            trend.setTrendViews(trendViewList);
                            trendList.add(trend);
                        }

                        consumer.accept(trendList);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    public void getRating(String category, Consumer<List<Rating>> consumer) {
        FirebaseDatabase.getInstance()
                .getReference("rating")
                .child(category)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List<HashMap<String, Object>> maptList = (List<HashMap<String, Object>>) dataSnapshot.getValue();
                        List<Rating> ratingList = new ArrayList<>();

                        for (HashMap<String, Object> map : maptList) {
                            Rating rating = new Rating();
                            rating.setEvaluation((String) map.get("evaluation"));
                            rating.setManagement((String) map.get("management"));
                            rating.setPerformance((String) map.get("performance"));
                            rating.setPriceper((String) map.get("priceper"));
                            rating.setRatingname((String) map.get("ratingname"));
                            rating.setEvaluation_name((String) map.get("evaluation_name"));
                            rating.setManagement_name((String) map.get("management_name"));
                            rating.setPerformance_name((String) map.get("performance_name"));
                            rating.setPriceper_name((String) map.get("priceper_name"));
                            ratingList.add(rating);
                        }

                        consumer.accept(ratingList);
                    }

                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}