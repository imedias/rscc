package ch.imedias.rsccfx.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests the rscc model class.
 */
public class RsccTest {
  Rscc model;

  @Before
  public void setUp() throws Exception {

  }

  @Ignore
  @Test
  public void requestTokenFromServer() throws Exception {
    final String terminalCommandUse = "bash resources/docker-build_p2p/use.sh 86.119.39.89 800";
    final String terminalCommandPortShare =
        "bash resources/docker-build_p2p/port_share.sh --p2p_server=86.119.39.89 --p2p_port=2201"
            + " --compress=yes 4999";
    SystemCommander mockCommander = mock(SystemCommander.class);
    model = new Rscc(mockCommander);

    when(mockCommander.executeTerminalCommand(terminalCommandPortShare)).thenReturn("6a2b9op6bq");

    String key = model.requestTokenFromServer(4999, "86.119.39.89", 2201, 800, true);

    // actual test
    verify(mockCommander).executeTerminalCommand(terminalCommandUse);
    assertEquals("6a2b9op6bq",key);
  }

}
