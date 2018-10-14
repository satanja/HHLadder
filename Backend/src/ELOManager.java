public abstract class ELOManager implements MMRCreator {

    public abstract void updateMMR(Match match);

    protected abstract int calculateWinnerMMR(ELOFencer winner, ELOFencer loser);

    protected abstract int calculateLoserMMR(ELOFencer winner, ELOFencer loser);
}
