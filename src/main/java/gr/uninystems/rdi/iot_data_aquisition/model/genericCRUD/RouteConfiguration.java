package gr.uninystems.rdi.iot_data_aquisition.model.genericCRUD;

public class RouteConfiguration {

    private final String routeBasePath;
    private final String routeObjectDescription;
    private final String routeIdentifier;
    private final String routeTimerName;
    private final boolean filteringSupported;
    private final boolean countSupported;
    private final boolean treeSupported;
    private final boolean formSupported;

    private RouteConfiguration(String routeBasePath, String routeObjectDescription, String routeIdentifier,
                               String routeTimerName, boolean filteringSupported, boolean countSupported, boolean treeSupported,
                               boolean formSupported) {
        this.routeBasePath = routeBasePath;
        this.routeObjectDescription = routeObjectDescription;
        this.routeIdentifier = routeIdentifier;
        this.routeTimerName = routeTimerName;
        this.filteringSupported = filteringSupported;
        this.countSupported = countSupported;
        this.treeSupported = treeSupported;
        this.formSupported = formSupported;
    }

    public String getRouteBasePath() {
        return routeBasePath;
    }

    public String getRouteObjectDescription() {
        return routeObjectDescription;
    }

    public String getRouteIdentifier() {
        return routeIdentifier;
    }

    public String getRouteTimerName() {
        return routeTimerName;
    }

    public boolean isFilteringSupported() {
        return filteringSupported;
    }

    public boolean isCountSupported() {
        return countSupported;
    }

    public boolean isTreeSupported() {
        return treeSupported;
    }

    public boolean isFormSupported() {
        return formSupported;
    }

    public static class BackendRouteConfigurationBuilder {

        private String routeBasePath;
        private String routeObjectDescription;
        private String routeIdentifier;
        private String routeTimerName;
        private boolean filteringSupported;
        private boolean countSupported;
        private boolean treeSupported;
        private boolean formSupported;

        private BackendRouteConfigurationBuilder() {
            // default private constructor
        }

        public static BackendRouteConfigurationBuilder getInstance() {
            return new BackendRouteConfigurationBuilder();
        }

        public BackendRouteConfigurationBuilder withBasePath(String basePath) {
            this.routeBasePath = basePath;
            return this;
        }

        public BackendRouteConfigurationBuilder withObjectDescription(String objectDescription) {
            this.routeObjectDescription = objectDescription;
            return this;
        }

        public BackendRouteConfigurationBuilder withIdentifier(String identifier) {
            this.routeIdentifier = identifier;
            return this;
        }

        public BackendRouteConfigurationBuilder withTimerName(String timerName) {
            this.routeTimerName = timerName;
            return this;
        }

        public BackendRouteConfigurationBuilder withFilteringSupport(boolean filteringSupported) {
            this.filteringSupported = filteringSupported;
            return this;
        }

        public BackendRouteConfigurationBuilder withCountSupport(boolean countSupported) {
            this.countSupported = countSupported;
            return this;
        }

        public BackendRouteConfigurationBuilder withTreeSupport(boolean treeSupported) {
            this.treeSupported = treeSupported;
            return this;
        }

        public BackendRouteConfigurationBuilder withPostForm(boolean formSupported) {
            this.formSupported = formSupported;
            return this;
        }

        public RouteConfiguration build() {
            return new RouteConfiguration(routeBasePath, routeObjectDescription, routeIdentifier, routeTimerName, filteringSupported, countSupported, treeSupported, formSupported);
        }
    }
}
