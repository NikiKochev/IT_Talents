package main;

import main.candidate.Candidate;
import main.voter.Voter;

import java.util.*;

public class CenElComm {
    private HashMap<Candidate, HashMap<City, HashSet<Voter>>>  ranking;
    private HashMap<Candidate, HashMap<City, HashSet<Voter>>> election;

    public CenElComm() {
        this.election = new HashMap<>();
    }

    public void gerstrationNewCandidate(HashSet<Voter> voters, Candidate candidate) {
        for (Voter v:voters) {
            if(!election.containsKey(candidate)) {
                election.put(candidate, new HashMap<>());
            }
            if(!election.get(candidate).containsKey(v.getCity())){
                election.get(candidate).put(v.getCity(),new HashSet<>());
            }
            election.get(candidate).get(v.getCity()).add(v);
        }
    }

    public void votingBegins(){
        this.ranking = new HashMap<>();
        int buyVotes = 0;
        int allVoters = 0;
        int nevalidni = 0;
        ArrayList<Candidate> candidate = new ArrayList<>();
        candidate.addAll(election.keySet());
        for (HashMap<City , HashSet<Voter>> a:election.values()) {
            for (HashSet<Voter>b: a.values()) {
                for (Voter v:b) {
                    allVoters++;
                    if(v.isItBribed()){
                        buyVotes++;
                    }
                   Candidate curent = v.vote(candidate);
                   if(!v.isTheBallotValid() || curent != null){
                       this.newVote(v,curent);
                   }
                   if(v.isTheBallotValid()){
                      nevalidni++;
                   }
                }
            }
        }
        this.rankingAfterTheElection();
        //1. Победител на изборите – кандидатът, генерирал най-много гласове.
        ArrayList<Map.Entry<Candidate, Integer>> c = winner();
        System.out.println(c.get(0).getKey() + " брой гласове" +c.get(0).getValue());
        //2. Runner up – кандидатът, на второ място от изборите.
        System.out.println(c.get(1).getKey() + " брой гласове" +c.get(1).getValue());
        //3. Общо гласували гласоподаватели (брой)
        int count = 0;
        for (Map.Entry<Candidate, Integer> x:c) {
            count += x.getValue();
        }
        System.out.println("Всички гласували са: "+ count);
        //4. Избирателна активност – процент гласоподаватели, които са гласували спрямо всички
        //генерирани гласоподаватели от кампаниите на кандидатите.
        double activity = (100/allVoters) * count;
        System.out.println(activity + " %");
        //5. Избирателна активност по градове – класиране на градовете, подредени по процент
        //избирателна активност.


        //6. Купени гласове за изборите – процент гласове, които са на купени гласоподаватели
        //спрямо всички подадени гласове.
        System.out.println( buyVotes);
        //7. Невалидни бюлетини – процент невалидни бюлетини спрямо всички подадени бюлетини
        System.out.println(nevalidni);

    }

    private ArrayList<Map.Entry<Candidate, Integer>> winner() {
        HashMap<Candidate, Integer> rankList= new HashMap<>();
        int temp= 0;
        for (Candidate c:ranking.keySet()) {
            for (City a : ranking.get(c).keySet()){
                temp += ranking.get(c).get(a).size();
            }
            rankList.put(c,temp);
        }
        ArrayList<Map.Entry<Candidate, Integer>> listRank = new ArrayList<>();
        for (Map.Entry<Candidate, Integer> e:rankList.entrySet()) {
            listRank.add(e);
        }
        listRank.sort((o1, o2) -> {
            if(o1.getValue() - o2.getValue() == 0){
                return o1.getKey().getName().compareToIgnoreCase(o2.getKey().getName());
            }
            return Integer.compare(o1.getValue(),o2.getValue());
        });
        return listRank;
    }

    private void rankingAfterTheElection() {
        for (Candidate c : ranking.keySet()){
            if(c!=null) {
                System.out.println("Кандидат " + c.getName());
            }
            for (City a : ranking.get(c).keySet()){
                System.out.println(a + " - " + ranking.get(c).get(a).size());
            }
        }
    }

    private void newVote(Voter v, Candidate curent) {
        if(!ranking.containsKey(curent)){
            ranking.put(curent,new HashMap<>());
        }
        if(!ranking.get(curent).containsKey(v.getCity())){
            ranking.get(curent).put(v.getCity(),new HashSet<>());
        }
        ranking.get(curent).get(v.getCity()).add(v);
    }
}
