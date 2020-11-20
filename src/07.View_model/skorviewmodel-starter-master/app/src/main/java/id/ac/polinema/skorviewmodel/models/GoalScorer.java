package id.ac.polinema.skorviewmodel.models;

import android.os.Parcel;
import android.os.Parcelable;

public class GoalScorer implements Parcelable {

	private String name;
	private int minute;

	public GoalScorer() {
	}

	public GoalScorer(String name, int minute) {
		this.name = name;
		this.minute = minute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeInt(this.minute);
	}

	protected GoalScorer(Parcel in) {
		this.name = in.readString();
		this.minute = in.readInt();
	}

	public static final Creator<GoalScorer> CREATOR = new Creator<GoalScorer>() {
		@Override
		public GoalScorer createFromParcel(Parcel source) {
			return new GoalScorer(source);
		}

		@Override
		public GoalScorer[] newArray(int size) {
			return new GoalScorer[size];
		}
	};

	@Override
	public String toString() {
		return "GoalScorer{" +
			"name='" + name + '\'' +
			", minute=" + minute +
			'}';
	}
}
