package id.ac.polinema.skorviewmodel.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import id.ac.polinema.skorviewmodel.R;
import id.ac.polinema.skorviewmodel.databinding.FragmentGoalBinding;
import id.ac.polinema.skorviewmodel.databinding.FragmentScoreBinding;
import id.ac.polinema.skorviewmodel.viewmodels.ScoreViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

	public static final String HOME = "home";
	public static final String AWAY = "away";
	public static final String SCORER_KEY = "scorer";

	private ScoreViewModel viewModel;

	public ScoreFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		FragmentScoreBinding binding = DataBindingUtil
			.inflate(inflater, R.layout.fragment_score, container, false);
		// instance viewmodel here
		binding.setFragment(this);
		binding.setLifecycleOwner(this);

		viewModel = new ViewModelProvider(requireActivity()).get(ScoreViewModel.class);

		binding.setVm(viewModel);
		return binding.getRoot();
	}

	public void onAddHomeClick(View view) {
		ScoreFragmentDirections.GoalScorerAction action =
				ScoreFragmentDirections.goalScorerAction(ScoreFragment.HOME);
		Navigation.findNavController(view).navigate(action);
		Log.d("clickbutton", "di click");
	}

	public void onAddAwayClick(View view) {
		ScoreFragmentDirections.GoalScorerAction action =
				ScoreFragmentDirections.goalScorerAction(ScoreFragment.AWAY);
		Navigation.findNavController(view).navigate(action);
	}


}