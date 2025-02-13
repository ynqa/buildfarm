// Copyright 2017 The Buildfarm Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package build.buildfarm.proxy.http;

import com.google.devtools.common.options.Converters.CommaSeparatedOptionListConverter;
import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;
import java.util.List;

/** Common options for authentication and TLS. */
public class AuthAndTLSOptions extends OptionsBase {
  @Option(
      name = "google_default_credentials",
      defaultValue = "false",
      help =
          "Whether to use 'Google Application Default Credentials' for authentication. See"
              + " https://cloud.google.com/docs/authentication for details. Disabled by default.")
  public boolean useGoogleDefaultCredentials;

  @Option(
      name = "google_auth_scopes",
      defaultValue = "https://www.googleapis.com/auth/cloud-platform",
      converter = CommaSeparatedOptionListConverter.class,
      help = "A comma-separated list of Google Cloud authentication scopes.")
  public List<String> googleAuthScopes;

  @Option(
      name = "google_credentials",
      defaultValue = "null",
      help =
          "Specifies the file to get authentication credentials from. See "
              + "https://cloud.google.com/docs/authentication for details.")
  public String googleCredentials;

  @Option(
      name = "tls_enabled",
      defaultValue = "false",
      help =
          "Specifies whether to use TLS for remote execution/caching and the build event service"
              + " (BES).")
  public boolean tlsEnabled;

  @Option(
      name = "tls_certificate",
      defaultValue = "null",
      help = "Specify the TLS client certificate to use.")
  public String tlsCertificate;

  @Option(
      name = "tls_authority_override",
      defaultValue = "null",
      help =
          "TESTING ONLY! Can be used with a self-signed certificate to consider the specified "
              + "value a valid TLS authority.")
  public String tlsAuthorityOverride;
}
