public class Vector2D implements Iterator<Integer> {
    Iterator <List<Integer> > j;
    Iterator <Integer> i;
    public Vector2D(List<List<Integer>> vec2d) {
        j=vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return i.next();
    }

    @Override
    public boolean hasNext() {
        while((i==null||!i.hasNext())&&j.hasNext())
            i=j.next().iterator();
        return !(i==null||i.hasNext()==false);
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
