package behavioral.chain_of_responsibility;

import java.util.LinkedList;
import java.util.List;

/**
 * 责任链
 */
public class FilterChain implements Filter {

    List<Filter> filters = new LinkedList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Object obj) {
        for (Filter filter : filters) {
            filter.doFilter(obj);
        }
    }
}
