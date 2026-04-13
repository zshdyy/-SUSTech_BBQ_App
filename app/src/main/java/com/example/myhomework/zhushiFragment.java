package com.example.myhomework;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class zhushiFragment extends Fragment {

    private RecyclerView rvZhushiCai;

    private final String[] names = {"主食1", "主食2", "主食3", "主食4", "主食5", "主食6", "主食7","主食8","主食9","主食10","主食11","主食12"};
    private final int[] infos = {R.string.zhushi1, R.string.zhushi2, R.string.zhushi3, R.string.zhushi4,
            R.string.zhushi5, R.string.zhushi6, R.string.zhushi7, R.string.zhushi8,
            R.string.zhushi9, R.string.zhushi10, R.string.zhushi11, R.string.zhushi12};


    public zhushiFragment() {
        // 必需的空公共构造函数
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 加载fragment的布局
        View view = inflater.inflate(R.layout.fragment_zhushi, container, false);
        rvZhushiCai = view.findViewById(R.id.zhushicai);

        // 设置RecyclerView布局管理器
        rvZhushiCai.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        // 设置RecyclerView适配器
        rvZhushiCai.setAdapter(new MyAdapter());

        // 设置itemView的间隔
        rvZhushiCai.addItemDecoration(new MyDecoration(20));

        return view;
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {

            holder.nameTextView.setText(names[position]);
            holder.infoTextView.setText(getString(infos[position]));
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        // ViewHolder类，初始化item内的控件
        public class MyHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView nameTextView, infoTextView;

            public MyHolder(@NonNull View itemView) {
                super(itemView);

                nameTextView = itemView.findViewById(R.id.tv_name);
                infoTextView = itemView.findViewById(R.id.tv_information);
            }
        }
    }

    // 自定义ItemDecoration类，用于设置RecyclerView中item间的间隔
    class MyDecoration extends RecyclerView.ItemDecoration {
        private final int space;

        public MyDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            outRect.set(0, 0, 0, space);
        }
    }
}