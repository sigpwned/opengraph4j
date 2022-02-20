package com.sigpwned.unpedantical;

import java.util.Optional;

public interface Microdata {
  public Optional<Microdatum<String>> getAuthor();
  
  public Optional<Microdatum<String>> getTitle();
  
  public Optional<Microdatum<String>> getAbstract();
}
