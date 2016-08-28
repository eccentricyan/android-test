package com.eccentricyan.drawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TopicFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TopicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopicFragment extends Fragment {

    private ViewPager mViewPager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TopicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopicFragment newInstance() {
        TopicFragment fragment = new TopicFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_topic, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.topic_tabs);
        mViewPager = (ViewPager) view.findViewById(R.id.topic_container);
        mViewPager.setAdapter(new Adapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private static class Adapter extends FragmentStatePagerAdapter {

        private static final String[] sTitles = {
                "閲覧週間",
                "閲覧月間",
                "オススメ",
                "ピックアップ",
        "テスト"};

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return sTitles.length;
        }

        @Override
        public Fragment getItem(int position) {
            return DummyFragment.newInstance(sTitles[position]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return sTitles[position];
        }
    }
    public static class DummyFragment extends Fragment {

        private static final String KEY_TITLE = "key_title";

        public static DummyFragment newInstance(String title) {
            DummyFragment fragment = new DummyFragment();

            Bundle args = new Bundle();
            args.putString(KEY_TITLE, title);
            fragment.setArguments(args);

            return fragment;
        }

        public DummyFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            String title = getArguments().getString(KEY_TITLE);

            TextView textView = new TextView(getContext());
            textView.setText(title);

            return textView;
        }
    }
}
