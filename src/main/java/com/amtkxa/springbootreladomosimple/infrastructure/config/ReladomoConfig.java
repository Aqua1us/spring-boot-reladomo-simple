package com.amtkxa.springbootreladomosimple.infrastructure.config;

import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.InputStream;

/**
 * Initialize Reladomo
 *
 * <p> Reladomo's runtime is configured via a MithraRuntime XML file.
 * Reladomo will cache an object as long as there is sufficient memory.
 * When there is a memory crunch, the cached objects will be garbage-collected.
 */
@Configuration
public class ReladomoConfig {
  private static int MAX_TRANSACTION_TIMEOUT = 60 * 1000; // (seconds)

  @PostConstruct
  public void postConstruct() throws Exception {
    initializeReladomo();
    loadReladomoXMLFromClasspath("reladomo/config/MithraRuntimeConfiguration.xml");
  }

  /**
   * Initialize Reladomo using MithraManager class.
   */
  public void initializeReladomo() {
    MithraManager mithraManager = MithraManagerProvider.getMithraManager();
    mithraManager.setTransactionTimeout(MAX_TRANSACTION_TIMEOUT);
  }

  /**
   * Load Reladomo runtime configuration file.
   *
   * @param fileName MithraRuntime XML file
   * @return stream
   * @throws Exception
   */
  private void loadReladomoXMLFromClasspath(String fileName) throws Exception {
    InputStream stream = ReladomoConfig.class.getClassLoader().getResourceAsStream(fileName);
    if (stream == null) {
      throw new Exception("Failed to locate " + fileName + " in classpath");
    }
    MithraManagerProvider.getMithraManager().readConfiguration(stream);
    stream.close();
  }
}
