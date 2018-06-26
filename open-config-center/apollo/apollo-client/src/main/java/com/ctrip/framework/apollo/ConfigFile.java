package com.ctrip.framework.apollo;

import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
public interface ConfigFile {
  /**
   * Get file content of the namespace
   * @return file content, {@code null} if there is no content
   */
  String getContent();

  /**
   * Whether the config file has any content
   * @return true if it has content, false otherwise.
   */
  boolean hasContent();

  /**
   * Get the namespace of this config file instance
   * @return the namespace
   */
  String getNamespace();

  /**
   * Get the file format of this config file instance
   * @return the config file format enum
   */
  ConfigFileFormat getConfigFileFormat();

  /**
   * Add change listener to this config file instance.
   *
   * @param listener the config file change listener
   */
  void addChangeListener(ConfigFileChangeListener listener);
}
