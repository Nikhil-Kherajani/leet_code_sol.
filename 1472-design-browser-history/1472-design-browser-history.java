import java.util.*;

class BrowserHistory {
    ArrayList<String> urls = new ArrayList<>();
    private int end = -1, curr = -1;

    public BrowserHistory(String homepage) {
        urls.add(homepage);
        curr = 0;
        end = 0;
    }

    public void visit(String url) {
        if (urls.size() - 1 == end && curr == end) {
            urls.add(url);
            curr++;
            end++;
        } else {
            if(end > curr)
               end = curr + 1;
            else
                end++;
            urls.set(end, url);
            curr++;
        }

    }

    public String back(int steps) {
        if (steps > curr) {
            steps = curr;
        }
        curr = curr - steps;
        return urls.get(curr);
    }

    public String forward(int steps) {
        if (steps > (end - curr)) {
            steps = (end - curr);
        }
        curr = curr + steps;
        return urls.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */