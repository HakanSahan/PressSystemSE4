package be.springPressOrder;

//@Configuration
//public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
   
   /**
    * Volgende configuratie override is nodig om de id's van Order en PressOrder te tonen, we hebben ze nodig
    * REST geeft ze anders niet als attribuut door omdat ze ook als URI beschikbaar zijn
    */
   /*@Override
   public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
       config.exposeIdsFor(Order.class);
       config.exposeIdsFor(PressOrder.class);
   }
}*/