package com.example.shogoyamada.meid.activity

import android.os.Bundle
import android.widget.ListView
import com.example.shogoyamada.meid.R
import com.example.shogoyamada.meid.adapeters.UserListViewAdapter
import com.example.shogoyamada.meid.common.BaseActivity
import com.example.shogoyamada.meid.models.ArticleCellModel
import java.util.*


class MyPageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        initListAdapter()
    }

    private fun initListAdapter(){

        // TODO 借りでテストデータの作成
        val articleList = ArrayList<ArticleCellModel>()
        var i = 0

        while (i <= 10){
            val model = ArticleCellModel()
            model.title = "これはタイトルです" + i
            model.date = "金曜日"
            model.article = "ここには" + i + "番目の記事を表示しています"
            articleList.add(model)

            i++
        }

        val listAdapter = UserListViewAdapter(this,R.layout.view_listview_cell,articleList)

        val listView = findViewById(R.id.post_list) as ListView
        listView.adapter = listAdapter

    }
}
