package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static ArrayList<Interval> merge(List<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}

	//	Collections.sort(intervals, new IntervalComparator());

		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) { 
			Interval curr = intervals.get(i);
			if (isOverlapped(curr, prev)) {
				prev.start = prev.start;
				prev.end = Math.max(curr.end, prev.end);
			} else {
				result.add(prev);
				prev = curr;
			}
		}

		result.add(prev);
		return result;
	}

	private static  boolean isOverlapped(Interval curr, Interval prev) {
		return curr.start <= prev.end;
	}

	private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}
	
	public static void main(String[] args) {
		Interval int1 = new Interval(1,4);
		Interval int2 = new Interval(2,6);
		Interval int3 = new Interval(6,7);
		Interval int4 = new Interval(7,9);
		Interval int5 = new Interval(8,10);
		Interval int6 = new Interval(10,14);
		Interval int7 = new Interval(11,14);
		Interval int8 = new Interval(12,16);
		Interval int9 = new Interval(16,24);
		Interval int10 = new Interval(20,24);
		
		List<Interval> intervalList = Arrays.asList(int1,int2,int3,int4,int5,int6,int7,int8,int9,int10);
		
		List<Interval>	merList = merge(intervalList);
		
		merList.forEach(e -> System.out.println("("+ e.start + ","+ e.end + ")" + "\n"));
	}

}
