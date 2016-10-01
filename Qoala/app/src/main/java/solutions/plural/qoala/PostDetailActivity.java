package solutions.plural.qoala;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import solutions.plural.qoala.Models.PostsDTO;

public class PostDetailActivity extends AppCompatActivity {

    private PostsDTO post = null;
    private TextView post_title = null;
    private TextView post_content = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle(R.string.title_activity_post);
        setSupportActionBar(myToolbar);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        String json = getIntent().getExtras().getString("post");
        post = PostsDTO.fromJson(json);

        post_title = (TextView) findViewById(R.id.post_title);
        post_title.setText(post.title);

        post_content = (TextView) findViewById(R.id.post_content);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            post_content.setText(Html.fromHtml(post.content, Html.FROM_HTML_MODE_COMPACT));
        }else{
            post_content.setText(Html.fromHtml(post.content));
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}