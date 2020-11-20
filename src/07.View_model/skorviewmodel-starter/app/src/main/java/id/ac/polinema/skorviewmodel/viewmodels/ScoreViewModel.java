package id.ac.polinema.skorviewmodel.viewmodels;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import java.util.ArrayList;

import id.ac.polinema.skorviewmodel.fragments.ScoreFragment;
import id.ac.polinema.skorviewmodel.fragments.ScoreFragmentDirections;
import id.ac.polinema.skorviewmodel.models.GoalScorer;

public class ScoreViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<GoalScorer>> homeGoalScorerList =
            new MutableLiveData<>(new ArrayList<GoalScorer>());
    private final MutableLiveData<ArrayList<GoalScorer>> awayGoalScorerList =
            new MutableLiveData<>(new ArrayList<GoalScorer>());

    public void setGoalScorer(String team, GoalScorer goalScorer) {
        if (team.equals(ScoreFragment.HOME)) {
            homeGoalScorerList.getValue().add(goalScorer);
        } else {
            awayGoalScorerList.getValue().add(goalScorer);
        }
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

    public String getHomeScorer(){
        StringBuilder result = new StringBuilder();
        for (GoalScorer g : homeGoalScorerList.getValue()){
            result.append(g.getName())
                    .append(" ")
                    .append(g.getMinute())
                    .append("\" ");
        }
        return  result.toString();
    }

    public String getAwayScorer() {
        StringBuilder result = new StringBuilder();
        for (GoalScorer g : awayGoalScorerList.getValue()) {
            result.append(g.getName())
                    .append(" ")
                    .append(g.getMinute())
                    .append("\" ");
        }
        return result.toString();
    }
}

