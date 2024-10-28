import java.util.List;

interface Driver {
  
    String getName();

    String getService(Request request);

    String getLicense();

    int getWaitingTime();

    double fareComputation_1(Request request);

    double fareComputation_2(Request request);

    List<Service> listOfServices();
    
}

