package strings.trie;

import java.util.List;

public interface ITrie {

    public void add(String string);
    public boolean contains(String string);
    public void remove(String string);
    public String lcp(String string);
    public List<String> autoComplete(String string);

}
