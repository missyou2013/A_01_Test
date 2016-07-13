package ac.test.liu.com.liuapplication.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ac.test.liu.com.liuapplication.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class TablayoutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "ARG_PAGE";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.f_tablayout_tv)
    TextView fTablayoutTv;

    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;
    private int mPage;



    public static TablayoutFragment newInstance(int param1 ) {
        TablayoutFragment fragment = new TablayoutFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablayout, container, false);
        ButterKnife.bind(this, view);
        fTablayoutTv.setText("Fragment #" + mParam1);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
