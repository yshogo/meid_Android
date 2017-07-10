package com.example.shogoyamada.meid.daos;

import com.example.shogoyamada.meid.models.ArticleSaveModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Firebaseを使ってDB作成して保存したり、取得したりする
 */

public class ArticleDao {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");

    /**
     * データを保存する
     * @param model 保存するデータ nullは許容しない!!
     */
    public void saveFirebase(ArticleSaveModel model){

        Map<String ,ArticleSaveModel> article = new HashMap<>();
        article.put("articles", model);

        DatabaseReference articleRef = ref.child("user_article");
        articleRef.setValue(model);
    }
}
