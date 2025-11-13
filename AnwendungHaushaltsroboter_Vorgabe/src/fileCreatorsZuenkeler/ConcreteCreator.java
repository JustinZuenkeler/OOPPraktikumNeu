package fileCreatorsZuenkeler;

public class ConcreteCreator extends ReaderCreatorZuenkeler{
	@Override
	public ReaderProductZuenkeler factoryMethod(String typ) {
		if("txt".equals(typ)){
			return new ConcreteTxtReaderProduct();
			}
		else{
			return new ConcreteCsvReaderProduct();
		}

	}


}
