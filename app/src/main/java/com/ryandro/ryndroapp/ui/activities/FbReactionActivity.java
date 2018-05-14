package com.ryandro.ryndroapp.ui.activities;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ryandro.ryndroapp.BaseActivity;
import com.ryandro.ryndroapp.R;
import com.ryandro.ryndroapp.widget.ReactionView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FbReactionActivity extends BaseActivity {
    @Nullable
    @BindView(R.id.root)
    FrameLayout root;
    @Nullable
    @BindView(R.id.btReaction)
    LinearLayout btReaction;

    @Override
    public void initialize() {
        inflater.inflate(R.layout.activity_fb_reaction, flBody, true);
        ButterKnife.bind(this);

        btReaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReactionView rvl = new ReactionView(FbReactionActivity.this);
                root.addView(rvl);
            }
        });
    }
}
